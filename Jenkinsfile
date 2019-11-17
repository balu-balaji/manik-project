pipeline {
   agent any
    stages {
        stage('git checkout') {
            steps {
             git 'https://github.com/balu-balaji/manik-project.git'   
            }
        }
        stage('movingectory') {
            steps {
        cd webcrud
           sh 'mvn clean install'
            }
        }
           
    }
    
    
}

