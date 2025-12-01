pipeline {
    agent any
    tools {
        maven "mvn"
    }


    environment {
        DOCKER_IMAGE = "charifray/bonjour21:${BUILD_NUMBER}"
        DOCKER_REGISTRY = "docker.io"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/YUKINEE1/bonjour20.git',
                    credentialsId: '5d54117f-6897-46b3-bcaa-22e638acf4d8'
            }
        }

      stage('Build Maven') {
            steps {
                        sh 'mvn clean package -DskipTests'

                    }    
        }

        stage('Build Docker Image') {
            steps {
                
                    sh "docker build -t ${DOCKER_IMAGE} ."
                
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
