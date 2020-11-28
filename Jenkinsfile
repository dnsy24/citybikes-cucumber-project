node {
        stage('Pull code from github'){
           git 'https://github.com/dnsy24/citybikes-cucumber-project.git'
        }

        stage('Run AcceptanceIT smoke test'){
            bat label: '', script: 'mvn test -Dcucumber.filter.tags="@testAll"'
        }

        stage('Generate cucumber report'){
            cucumber fileIncludePattern: '**/*.json', sortingMethod: 'ALPHABETICAL'
        }

        stage('Send email notification') {
            emailtext body: '''$DEFAULT_CONTENT
            <h1>Cucumber Report:</h1>
            http://54.224.207.148:8081/job/smoke-test-pipeline/${BUILD_NUMBER}/cucumber-html-reports/overview-features.html''',
            subject: 'Smoke test status ${BUILD_STATUS}', to: 'yatsunov.dev@gmail.com'
        }
}
