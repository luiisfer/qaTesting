def checkout = { String subFolder ->
    checkout([
            $class      : "GitSCM",
            branches    : [[name: "*/master"]],
            extensions  : [[ $class: "RelativeTargetDirectory",
                             relativeTargetDir: subFolder
                           ]],
            userRemoteConfigs: [[
                                        url : 'git@github.com:luiisfer/qaTesting.git',
                                        credentialsId: "jenkins"
                                ]]
    ])
}

def runner = { commandToExecute -> isUnix() ? sh(commandToExecute) : bat(commandToExecute) }


unitTest:{
    stage("Unit Testing"){
        node('MyNewNode'){
            checkout("tests")
            runner 'cd tests && mvn test -Dgroups=unitTesting'
        }
    }
}
IntegrationTest:{
    stage("Integration Testing"){
        node('MyNewNode'){
            checkout("tests")
            runner 'cd tests && mvn test -Dtest=integrationTesting.UserIT,integrationTesting.SupplierIT,integrationTesting.ProductIT,integrationTesting.InvoiceIT,integrationTesting.ClientIT'
        }
    }
}
