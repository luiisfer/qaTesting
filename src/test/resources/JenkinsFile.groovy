def runner = { commandToExecute -> isUnix() ? sh(commandToExecute) : bat(commandToExecute) }


unitTest:{
    stage("Unit Testing"){
        node('MyNewNode'){
            runner 'mvn test -Dgroups=unitTesting'
        }
    }
}
IntegrationTest:{
    stage("Integration Testing"){
        node('MyNewNode'){
            runner 'mvn test -Dgroups=unitTesting'
        }
    }
}
