pipeline {
    agent any
    stages {
        stage('init'){
            steps{
                echo "Testing..."
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
                echo "Code Deployed..."
                // build job: 'TestJenkinsDeploy'
            }
        }
    }
}