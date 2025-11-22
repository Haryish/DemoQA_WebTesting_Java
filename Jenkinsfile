pipeline {
    agent any

    tools {
        jdk 'JDK_21'
        maven 'Maven 3_9'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/Haryish/DemoQA_WebTesting_Java.git'
            }
        }

        stage('Run TestNG - HealthCheck') {
            steps {
                bat 'mvn clean test -DsuiteXmlFile=testng/healthCheck.xml'
            }
        }

        stage('Publish Reports') {
            steps {
                junit 'target/surefire-reports/*.xml'
            }
        }
    }
}
