pipeline {
    agent any
    stages {
        // stage('init'){
        //     steps{
        //         echo "Testing...."
        //     }
        // }
        stage('Build'){
            steps{
                echo "Building..."
                sh 'mvn clean package -DskipTests'
            }
            // post{
            //     success{
            //         echo '開始存檔'
            //         archiveArtifacts artifacts: '**/target/*.jar'
            //     }
            // }
        }
        // stage('Docker-compose down'){
        //     steps{
        //         bat 'docker-compose down'
        //     }
        // }
        // stage('Docker image rmi'){
        //     steps{
        //         if(fileExists('./simpleauth')){
        //             echo "image simpleauth exist"
        //             bat 'docker image rmi simpleauth'
        //         } else {
        //             echo "image simpleauth not exist"
        //         }
        //     }
        // }
        // stage('Docker-compose up'){
        //     steps{
        //         bat 'docker-compose up -d'
        //     }
        // }
    }
}