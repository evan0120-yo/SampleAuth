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
        stage('Deploy'){
            steps{
                echo "Code Deployed docker-compose down start..."
                bat 'docker-compose down'
            }
            steps{
                echo "Code Deployed docker image rmi start..."
                bat 'docker image rmi simpleauth'
            }
            step{
                echo "Code Deployed docker-compose up start..."
                bat 'docker-compose up -d'
            }
        }
    }
}