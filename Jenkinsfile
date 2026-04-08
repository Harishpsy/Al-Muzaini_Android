pipeline {
    agent any

    parameters {
        string(name: 'ENV', defaultValue: 'qa', description: 'Environment to run tests (qa, staging, prod)')
        string(name: 'PLATFORM', defaultValue: 'android', description: 'Target platform (android, ios)')
    }

    environment {
        MAVEN_HOME = tool 'Maven 3.9.x'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh "${MAVEN_HOME}/bin/mvn clean compile"
            }
        }

        stage('Execute Tests') {
            steps {
                sh "${MAVEN_HOME}/bin/mvn test -Denv=${params.ENV} -Dplatform=${params.PLATFORM}"
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'reports/*.html, logs/*.log, screenshots/*.png', allowEmptyArchive: true
            publishHTML([allowMissing: false, alwaysLinkToLastBuild: true, keepAll: true, reportDir: 'reports', reportFiles: '*.html', reportName: 'Appium-Extent-Report', reportTitles: 'Test Execution Results'])
        }
    }
}
