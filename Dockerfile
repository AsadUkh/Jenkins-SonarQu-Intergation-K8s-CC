FROM jenkins/jenkins:lts-jdk11

MAINTAINER Asad ullah Khan

ENV JAVA_OPTS="-Djenkins.install.runSetupWizard=false"

COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN /usr/local/bin/install-plugins.sh < /usr/share/jenkins/ref/plugins.txt

COPY groovy/* /usr/share/jenkins/ref/init.groovy.d/
#Below Line is added to copy maven and java downloaded tar files to install
COPY downloads/* /var/jenkins/downloads/

