pipeline {
 agent any
    parameters {
        string(name: 'FEATURE_FILE', defaultValue: 'smokeTests.feature', description: 'Path to the feature file')
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/your/repository.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                // Run Cucumber tests with the provided feature file
                sh "mvn test -Dcucumber.options=src/test/resources/features/${params.FEATURE_FILE}"
            }

            post {
                always {
                    junit 'target/cucumber-reports/*.xml'
                }
            }
        }
}
}
