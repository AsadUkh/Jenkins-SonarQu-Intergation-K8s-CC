import hudson.model.JDK
import hudson.tools.InstallSourceProperty
import hudson.tools.ZipExtractionInstaller

def descriptor = new JDK.DescriptorImpl();


def List<JDK> installations = []

javaTool=['name':'jdk11', 'url':'file:/var/jenkins/downloads/jdk-11.0.7_linux-x64_bin.tar.gz', 'subdir':'jdk-11.0.7']

//javaTools.each { javaTool ->

    println("Setting up tool: ${javaTool.name} ")


    def installer = new ZipExtractionInstaller(javaTool.label as String, javaTool.url as String, javaTool.subdir as String);
    def jdk = new JDK(javaTool.name as String, null, [new InstallSourceProperty([installer])])
    installations.add(jdk)

//}
descriptor.setInstallations(installations.toArray(new JDK[installations.size()]))
descriptor.save()
