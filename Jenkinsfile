pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "charifray/bonjour21:${BUILD_NUMBER}"
        DOCKER_REGISTRY = "docker.io"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/YUKINEE1/bonjour21.git',
                    credentialsId: 'github-bonjour21'
            }
        }

        stage('Build Maven') {
            steps {
                 docker.image('maven:3.9.6-eclipse-temurin-21').inside {
                    dir('bonjour21'){
                        sh 'mvn clean package -DskipTests'

                    }
 }
                }

        }

        stage('Build Docker Image') {
            steps {
                dir('bonjour21') {
                    sh "docker build -t ${DOCKER_IMAGE} ."
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'dockerhub-credentials',
                    usernameVariable: 'USER',
                    passwordVariable: 'PASS'
                )]) {
                    sh "echo $PASS | docker login ${DOCKER_REGISTRY} -u $USER --password-stdin"
                    sh "docker push ${DOCKER_IMAGE}"
                }
            }
        }

        stage('Deploy') {
            steps {
                echo "Déploiement possible via kubectl..."
            }
        }
    }

    post {
        always {
            cleanWs()
        }
    }
}
