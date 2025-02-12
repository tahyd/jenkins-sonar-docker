pipeline {
    agent any
    
    environment{
        sonarHome= tool "sonar-scanner"
    }
    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "maven3"
        jdk "jdk21"
    }

    stages {
        stage('CheckOut') {
            steps {
                
                git branch: 'main', 
                credentialsId: 'github',
                url: 'https://github.com/tahyd/sonarqube-springboot.git'
                
                // Run Maven on a Unix agent.
                //sh "mvn -Dmaven.test.failure.ignore=true clean package"

               
            }
            
           
           
        }
        
        
    
        
         stage('SonarQube Analyze'){
                steps{
                    withSonarQubeEnv("sonarqube"){
                        bat "${sonarHome}/bin/sonar-scanner"
                    }
                }
            }
            
            stage("Sonar QualityGate"){
                steps {
                    
                    script {
                        def qualityGate = waitForQualityGate();
                        echo "${qualityGate.status}"
                        
                        if(qualityGate.status != "OK"){
                           timeout(time: 2, unit: 'MINUTES') {
                waitForQualityGate abortPipeline: true }
            }
                        }
                    }
                }
            }

    }

