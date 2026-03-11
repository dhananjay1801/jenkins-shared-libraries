def call(String Project, String ImageTag, String DockerHubUser){
  echo "pushing..."

  withCredentials([usernamePassword(
      credentialsId: "dockerHubCred",
      passwordVariable: "dockerHubPass",
      usernameVariable: "dockerHubUser")]) {

      sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
      sh "docker tag ${Project}:${ImageTag} ${env.dockerHubUser}/${Project}:${ImageTag}"
      sh "docker push ${env.dockerHubUser}/${Project}:${ImageTag}"
  }
}
