def runner = { commandToExecute -> isUnix() ? sh(commandToExecute) : bat(commandToExecute) }


unitTest:{
    stage("Unit Testing"){
        node('MyNewNode'){
            checkout("tests")
            runner 'cd tests && mvn test -DincludeGroup=unitTesting'
        }
    }
}
IntegrationTest:{
    stage("Integration Testing"){
        node('MyNewNode'){
            checkout("tests")
            runner 'cd tests && mvn test -DincludeGroup=unitTesting'
        }
    }
}
