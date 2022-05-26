pipeline {
    agent any
    environment {
        REPOSITORY_DOCKER = 'u2dtecnologia/multithread'
        CREDENTIAL_DOCKER = 'u2dtecnologia'
        IMAGE_DOCKER = ''
        EMAIL_TO = 'u2dtecnologia@gmail.com'
    }
    tools {
            maven '3.8.5'
            jdk 'OpenJDK-8'
    }
    stages {
        stage('Git checkout') {
        	steps {
	            checkout scm
	            	script {
	            	    VERSAO_POM = readMavenPom().getVersion()
	            	}
	        }
        }
        stage('Maven Build') {
           steps {
               sh "mvn -version"
               sh "mvn clean install"
           }
        }
        stage('Arquivar JAR') {
           steps {
               archiveArtifacts artifacts: 'target/multithread.jar', allowEmptyArchive: true
           }
        }
        stage('Building image Docker') {
           steps {
               script {
                   IMAGE_DOCKER = docker.build REPOSITORY_DOCKER + ":$BUILD_NUMBER"
               }
           }
        }
        stage('Deployment image DockerHub') {
           steps {
               script {
                   docker.withRegistry('', CREDENTIAL_DOCKER) {
                    IMAGE_DOCKER.push()
                   }
               }
           }
        }
        stage('Remove Unused docker image') {
           steps {
               sh "docker rmi $REPOSITORY_DOCKER:$BUILD_NUMBER"
           }
        }
    }
    post {
        failure {
            mail bcc: '',
            body: "${currentBuild.fullDisplayName} - Build #${env.BUILD_NUMBER} - ${currentBuild.result}: \n Check console output at ${env.BUILD_URL} to view the results.",
            cc: '',
            from: '',
            replyTo: '',
            subject: "${currentBuild.fullDisplayName} - Build # ${env.BUILD_NUMBER} - ${currentBuild.result}!",
            to: "${EMAIL_TO}"
        }
    }
}