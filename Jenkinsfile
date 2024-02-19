pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'improvements', url: 'https://github.com/KasiaGrochal/tmobile-test-framework'
            }
        }

        stage('Build') {
            steps {
                bat "mvn clean compile"
            }
        }
        stage('Test') {
            steps {
                bat "mvn test -DBrowser_Value=${browser} -Dtags=@SmokeTest"
            }
        }
    }
}