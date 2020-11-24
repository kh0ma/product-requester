podTemplate(containers: [
  containerTemplate(name: 'maven', image: 'maven:3.6.0-jdk-8-alpine', ttyEnabled: true, command: 'cat')
  ]) {

  node(POD_LABEL) {
    stage('Build a Maven project') {
      checkout scm
      container('maven') {
          sh 'mvn -B clean package'
      }
    }
  }
}
