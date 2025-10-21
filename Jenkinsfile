pipeline {
    agent { label 'ec2-fleet' }

    environment {
        MAVEN_OPTS = '-Xmx2048m'
        JAVA_HOME = '/usr/lib/jvm/java-21-openjdk-amd64'
        TEST_ENV = 'prod'
        RUN_HEADLESS = 'true'
    }

    options {
        buildDiscarder(logRotator(numToKeepStr: '10'))
        timeout(time: 4, unit: 'HOURS')
        parallelsAlwaysFailFast()
    }

    stages {
        stage('Parallel Test Execution') {
            parallel {
                stage('Test Suite 1') {
                    agent any
                    steps {
                        script {
                            runTestSuiteWithCleanup('synMonRest_suite1.xml', 'Suite_1', 1)
                        }
                    }
                    post {
                        always {
                            script {
                                archiveAndCleanup('1', 'Suite 1 Test Report')
                            }
                        }
                    }
                }

                stage('Test Suite 2') {
                    agent any
                    steps {
                        script {
                            runTestSuiteWithCleanup('synMonRest_suite2.xml', 'Suite_2', 2)
                        }
                    }
                    post {
                        always {
                            script {
                                archiveAndCleanup('2', 'Suite 2 Test Report')
                            }
                        }
                    }
                }

                stage('Test Suite 3') {
                    agent any
                    steps {
                        script {
                            runTestSuiteWithCleanup('synMonRest_suite3.xml', 'Suite_3', 3)
                        }
                    }
                    post {
                        always {
                            script {
                                archiveAndCleanup('3', 'Suite 3 Test Report')
                            }
                        }
                    }
                }

                stage('Test Suite 4') {
                    agent any
                    steps {
                        script {
                            runTestSuiteWithCleanup('synMonRest_suite4.xml', 'Suite_4', 4)
                        }
                    }
                    post {
                        always {
                            script {
                                archiveAndCleanup('4', 'Suite 4 Test Report')
                            }
                        }
                    }
                }

                stage('Test Suite 5') {
                    agent any
                    steps {
                        script {
                            runTestSuiteWithCleanup('synMonRest_suite5.xml', 'Suite_5', 5)
                        }
                    }
                    post {
                        always {
                            script {
                                archiveAndCleanup('5', 'Suite 5 Test Report')
                            }
                        }
                    }
                }

                stage('Test Suite 6') {
                    agent any
                    steps {
                        script {
                            runTestSuiteWithCleanup('synMonRest_suite6.xml', 'Suite_6', 6)
                        }
                    }
                    post {
                        always {
                            script {
                                archiveAndCleanup('6', 'Suite 6 Test Report')
                            }
                        }
                    }
                }

                stage('Test Suite 7') {
                    agent any
                    steps {
                        script {
                            runTestSuiteWithCleanup('synMonRest_suite7.xml', 'Suite_7', 7)
                        }
                    }
                    post {
                        always {
                            script {
                                archiveAndCleanup('7', 'Suite 7 Test Report')
                            }
                        }
                    }
                }
            }
        }
    }

    post {
        always {
            echo 'Test execution completed'
            // Archive all test artifacts
            archiveArtifacts artifacts: '**/target/surefire-reports/**/*', allowEmptyArchive: true
            // Publish JUnit test results
            junit testResults: '**/target/surefire-reports/*.xml', allowEmptyResults: true
            // Clean workspace to free disk space
            cleanWs()
        }
        success {
            echo 'All test suites passed successfully!'
        }
        failure {
            echo 'One or more test suites failed. Check the test reports for details.'
        }
    }
}

def runTestSuiteWithCleanup(xmlFile, suiteName, suiteNumber) {
    echo "Running test suite: ${xmlFile} (${suiteName})"

    // Pre-execution cleanup
    sh '''
        # Clean up any existing test artifacts
        rm -rf target/surefire-reports* || true
        rm -rf target/screenshots* || true
        rm -rf target/test-output* || true

        # Clean browser cache and temp files
        rm -rf ~/.cache/google-chrome* || true
        rm -rf /tmp/chrome_* /tmp/.org.chromium.* || true

        # Display disk usage before test
        echo "Disk usage before test execution:"
        df -h
    '''

    try {
        // Checkout code
        checkout scm

        // Setup environment
        setupTestEnvironment()

        // Run the specific test suite
        sh """
            echo "Starting ${suiteName} test execution with ${xmlFile}"
            mvn clean test \\
                -Dsurefire.suiteXmlFiles=${xmlFile} \\
                -Drun.headless=${env.RUN_HEADLESS} \\
                -Dtest.env=${env.TEST_ENV} \\
                -Dmaven.test.failure.ignore=true \\
                -Duser.timezone=UTC \\
                -Dmaven.repo.local=\${WORKSPACE}/.m2/repository
        """

    } catch (Exception e) {
        echo "Test execution completed with some failures: ${e.getMessage()}"
    }

    // Verify test results exist and organize artifacts
    sh """
        # Verify test results exist
        ls -R target/surefire-reports || echo "Test results missing!"

        # Create suite-specific directory for screenshots and reports
        if [ -d "target/surefire-reports" ]; then
            mkdir -p "target/surefire-reports-${suiteName}"
            cp -r target/surefire-reports/* "target/surefire-reports-${suiteName}/" || true

            # Keep screenshots in direct folder (not zipped) for easy viewing in Jenkins
            if [ -d "target/surefire-reports-${suiteName}/screenshots" ]; then
                echo "Screenshots directory found and will be archived as-is"
            fi

            # Create summary report
            echo "Test Suite: ${xmlFile}" > "target/surefire-reports-${suiteName}/suite-info.txt"
            echo "Suite Name: ${suiteName}" >> "target/surefire-reports-${suiteName}/suite-info.txt"
            echo "Suite Number: ${suiteNumber}" >> "target/surefire-reports-${suiteName}/suite-info.txt"
            echo "Execution Time: \$(date)" >> "target/surefire-reports-${suiteName}/suite-info.txt"
        fi

        # Display disk usage after test
        echo "Disk usage after test execution:"
        df -h
    """
}

def setupTestEnvironment() {
    sh '''
        echo "Setting up test environment..."

        # Clean up any existing temporary files
        rm -rf /tmp/chrome_* /tmp/.org.chromium.* || true

        # Set JAVA_HOME to the correct OpenJDK path
        export JAVA_HOME='/usr/lib/jvm/java-21-openjdk-amd64'
        echo "Set JAVA_HOME to: $JAVA_HOME"

        # Use existing Java installation
        echo "Current Java version:"
        java -version

        # Check if Maven is available
        if command -v mvn &> /dev/null; then
            echo "Maven version:"
            mvn -version
        else
            echo "ERROR: Maven not found in Jenkins environment"
            exit 1
        fi

        # Check for browser availability
        if command -v google-chrome &> /dev/null; then
            echo "Chrome version:"
            google-chrome --version
        elif command -v chromium-browser &> /dev/null; then
            echo "Chromium version:"
            chromium-browser --version
        else
            echo "WARNING: No browser found for headless testing"
        fi

        # Set up workspace
        echo "Setting up workspace..."
        mkdir -p target/surefire-reports

        # Display available disk space
        df -h

        echo "Environment setup complete"
    '''
}

def archiveAndCleanup(suiteNumber, reportName) {
    echo "Archiving artifacts and performing cleanup for suite ${suiteNumber}"

    // Archive artifacts - screenshots will be in direct folders, not zipped
    archiveArtifacts artifacts: 'target/surefire-reports*/**/*', allowEmptyArchive: true, fingerprint: true

    // Cleanup to save disk space
    sh """
        # Clean up large temporary files but keep archived artifacts
        rm -rf target/classes || true
        rm -rf target/test-classes || true
        rm -rf target/maven-* || true

        # Clean browser temp files
        rm -rf ~/.cache/google-chrome* || true
        rm -rf /tmp/chrome_* /tmp/.org.chromium.* || true

        # Clean Maven temp files
        rm -rf ~/.m2/repository/com/cutanddry/*/target || true

        echo "Cleanup completed for suite ${suiteNumber}"
        df -h
    """
}
