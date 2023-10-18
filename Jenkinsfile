// defiine stages
pipeline {
    agent any
    tools{
        maven 'maven-3.9.5'
    }
    stages {
        stage('Build') {
            steps {
                echo 'Building...'
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/r4hulr4j/cicd-with-jenkins.git']]])
                sh 'mvn clean package'
                echo 'Build completed'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing...'
                sh 'mvn test'
                echo 'Testing completed'
            }
        }
        stage('Build Docker Image') {
            steps {
                echo 'Building Docker Image...'
                sh 'docker build -t ram1uj/cicd-with-jenkins:latest .'
                echo 'Docker Image Build completed'
            }
        }
        stage('Push Docker Image') {
            steps {
                echo 'Pushing Docker Image...'
                withCredentials([string(credentialsId: 'dockerhub_credentials', variable: 'dockhub_credentials')])  {
                    sh 'docker login -u ram1uj -p $dockhub_credentials'
                }
                sh 'docker push ram1uj/cicd-with-jenkins:latest'
                echo 'Docker Image Push completed'
            }
        }
        
    }
}
