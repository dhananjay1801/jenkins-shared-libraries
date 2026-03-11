def call(String ProjectName, String ImageTag, String DockerHubUser){
  echo "building...."
  sh "docker build -t ${DockerHubUser}/${ProjectName}:${ImageTag} ."
}
