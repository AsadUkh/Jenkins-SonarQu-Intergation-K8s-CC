Jenkins-SonarQu-Intergation-K8s-CC

Steps to run:

Create Directories for Storage on Kubernetes Node at below mentioned path 
“/mnt/”

sudo mkdir /mnt/{jenkin-job,pgdata,sonar-data,sonar-extenstions}


Clone this Repo 

https://github.com/AsadUkh/Jenkins-SonarQu-Intergation-K8s-CC.git


Navigate to the kubernetes folder and execute command 

kubectl create -f .


Note:
I am using One Master Node and One Worker Node on-prem Kubernetes Cluster,so it always running on that worker node . One Thing is to mention that if we have multiple worker nodes we have to use  Node Selector in deployment yamls files to make sure that your pods always runs on same Node so that we don’t loose our data ( i.e volume mounted on /mnt/) even if Master reshedule Pods in case of any failure.
To Overcome this problem use Cloud Storage (I.e EFS,EBS Azure Disk)  for Data Persistency.



Description of Flow:

    • I have Build Custom Dokcer Image of Jenkins with Java and Maven Support. Groovy Scripts are used to install Java 11 and Maven in Jenkins.I did this because when Jenkins starts, it runs all scripts in a directory called init.groovy.
      
    • All required and necessary Plugin will be installed from plugins.txt I.e Sonar Scanner,Jacoco.
      
    • Dockerfile uses Download folder to copy Apache Maven and JavaJdk into   the Container and then groovy scripts will installed it from the respective  tar file 
      
    • Custom Jenkins Image is pushed on Docker Hub:
      
    • asadullahkhan/custom-jenkins-java11:v4 which is updated image i used in our kubernetes deployment yaml file
      
    • I used  Persistent Volume and Persistent Volume Claim for Persistent Storage on my kubernetes host file system  as I don’t have any cloud storage available I.e EFS,EBS Azure Disk. 

    • Used Node Port to Access SonarQube and Jenkins Web Interface outside the Cluster. 
      
    • Also Sonar is connected to an external PosgreSQL database.


CICD Pipeline:

Successfully Run Builds using JenkinFiles (Declarative Pipeline) of both repos

https://github.com/AsadUkh/Java-Berlin-Clock
https://github.com/ssqasim-cc/K8s-CI-Jenkins/tree/master

Jenkinsfiles for both Repos are also in this Repository

https://github.com/AsadUkh/Jenkins-SonarQu-Intergation-K8s-CC.git






 
