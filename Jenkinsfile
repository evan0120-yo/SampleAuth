pipeline {
    agent any
    stages {
        stage('init'){
            steps{
                echo "Testing...."
            }
        }
        stage('Build'){
            steps{
                echo "Building..."
                bat 'mvn clean package -DskipTests'
            }
            post{
                success{
                    echo '開始存檔'
                    archiveArtifacts artifacts: '**/target/*.jar'
                }
            }
        }
        stage('Docker-compose down'){
            steps{
                bat 'docker-compose down'
            }
        }
        stage('Docker image rmi'){
            steps{
                bat 'docker image rmi simpleauth'
            }
        }
        stage('Docker-compose up'){
            steps{
                bat 'docker-compose up -d'
            }
        }
    }
}