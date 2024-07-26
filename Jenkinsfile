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
                echo "Code Deployed docker-compose down start..."
            }
        }
        stage('Docker image rmi'){
            steps{
                echo "Code Deployed docker image rmi start..."
            }
        }
        stage('Docker-compose up'){
            steps{
                echo "Code Deployed docker-compose up start..."
                bat 'docker-compose up -d'
            }
        }
    }
}