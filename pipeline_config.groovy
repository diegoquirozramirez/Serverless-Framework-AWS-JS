pipeline_template = "template_default"

agent any

def scriptDir = getClass().protectionDomain.codeSource.location.path

libraries{
    npm {
        image_tag = "node:10.16.3-alpine"
        dockerfile = "${scriptDir}/Dockerfile"
        docker_compose = "${scriptDir}/docker-compose.yaml"
        example = "${scriptDir}/example.sh"
        dir = "${scriptDir}"
    }
    sonarqube
    ansible
}

application_environments{
    dev{
        long_name = "Development"
        ip_addresses = [ "0.0.0.1", "0.0.0.2" ]
    }
    prod{
        long_name = "Production"
        ip_addresses = [ "0.0.1.1", "0.0.1.2", "0.0.1.3", "0.0.1.4" ]
    }
}