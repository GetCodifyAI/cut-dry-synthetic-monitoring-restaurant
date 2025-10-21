pipeline {
    agent { label 'ec2-fleet' }

    stages {
        stage('Setup Environment') {
            steps {
                script {
                    echo "Setting up environment for test execution"
                    echo "Test Environment: prod"
                    echo "Headless Mode: true"
                }
            }
        }

        stage('Parallel Test Execution') {
            parallel {
                stage('Test Suite 1') {
                    agent any
                    steps {
                        script {
                            runTestSuite('synMonRest_suite1.xml', '1')
                        }
                    }
                }

                stage('Test Suite 2') {
                    agent any
                    steps {
                        script {
                            runTestSuite('synMonRest_suite2.xml', '2')
                        }
                    }
                }

                stage('Test Suite 3') {
                    agent any
                    steps {
                        script {
                            runTestSuite('synMonRest_suite3.xml', '3')
                        }
                    }
                }

                stage('Test Suite 4') {
                    agent any
                    steps {
                        script {
                            runTestSuite('synMonRest_suite4.xml', '4')
                        }
                    }
                }

                stage('Test Suite 5') {
                    agent any
                    steps {
                        script {
                            runTestSuite('synMonRest_suite5.xml', '5')
                        }
                    }
                }

                stage('Test Suite 6') {
                    agent any
                    steps {
                        script {
                            runTestSuite('synMonRest_suite6.xml', '6')
                        }
                    }
                }

                stage('Test Suite 7') {
                    agent any
                    steps {
                        script {
                            runTestSuite('synMonRest_suite7.xml', '7')
                        }
                    }
                }
            }
        }
    }

    post {
        always {
            echo 'Test execution completed'
            echo 'Archiving test reports and screenshots...'
            // Archive surefire reports and screenshots
            archiveArtifacts artifacts: '**/target/surefire-reports/**/*', allowEmptyArchive: true, fingerprint: true
            // Publish JUnit test results
            junit testResults: '**/target/surefire-reports/*.xml', allowEmptyResults: true
            echo 'Cleaning up workspace to free disk space...'
            // Clean workspace but keep archived artifacts in Jenkins
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

def runTestSuite(String suiteFile, String suiteNumber) {
    echo "Running Test Suite ${suiteNumber}: ${suiteFile}"

    // Install Java 22
    sh '''
        echo "Installing Java 22..."
        if [ ! -d "/usr/lib/jvm/jdk-22" ]; then
            wget -q https://download.java.net/java/GA/jdk22/830ec9fcccef480bb3e73fb7ecafe059/36/GPL/openjdk-22_linux-x64_bin.tar.gz
            sudo mkdir -p /usr/lib/jvm
            sudo tar zxf openjdk-22_linux-x64_bin.tar.gz -C /usr/lib/jvm
            sudo update-alternatives --install /usr/bin/java java /usr/lib/jvm/jdk-22/bin/java 2200
        fi
        export PATH="/usr/lib/jvm/jdk-22/bin:$PATH"
        java -version
    '''

    // Install Maven
    sh '''
        echo "Installing Maven..."
        if ! command -v mvn &> /dev/null; then
            sudo apt-get update
            sudo apt-get install -y maven
        fi
        mvn -version
    '''

    // Install Chrome
    sh '''
        echo "Installing Chrome..."
        if ! command -v google-chrome &> /dev/null; then
            wget -q -O - https://dl.google.com/linux/linux_signing_key.pub | sudo apt-key add -
            sudo sh -c 'echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google-chrome.list'
            sudo apt-get update
            sudo apt-get install -y google-chrome-stable
        fi
        google-chrome --version
    '''

    // Run tests
    sh """
        echo "Running tests for suite: ${suiteFile}"
        export PATH="/usr/lib/jvm/jdk-22/bin:\$PATH"
        mvn clean test -Dsurefire.suiteXmlFiles=${suiteFile} -Drun.headless=true -Dtest.env=prod
    """
}
