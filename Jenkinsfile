pipeline{
    
    agent any 
    
    tools {
        maven "maven3"
        jdk "jdk21"
    }
    
    stages{
        
        // pull code from git 
        
        stage('Pull from Git'){
            steps{
            
              git url:'https://github.com/tahyd/jenkins-sonar-docker.git',
               branch:'main'
            }
        }
        
        stage('Build Jar'){
            
            steps{
                bat 'mvn clean package'
            }
        }
    }
}