pipeline {
    agent any

    environment {
        DOCKER_CREDENTIALS_ID = 'docker-hub-cred'
        IMAGE_NAME = 'yourdockerusername/feedback-app'
    }

    stages {

        stage('Clone') {
            steps {
                git 'https://github.com/abiramis2023-ux/submission.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Docker Build') {
            steps {
                script {
                    docker.build("${IMAGE_NAME}")
                }
            }
        }

        stage('Docker Push') {
            steps {
                script {
                    docker.withRegistry('', DOCKER_CREDENTIALS_ID) {
                        docker.image("${IMAGE_NAME}").push("latest")
                    }
                }
            }
        }
    }
}