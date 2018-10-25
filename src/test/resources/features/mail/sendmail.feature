@api
@mails
Feature: Scenarios to verify sendmail with different mail types

  Background: Background
    * url serverUrl
#    * configure ssl = true
    * def basicAuth = read('classpath:sign-in.js')
    * def poleary = call basicAuth {username: 'poleary', password: #(password)}
    * def tyeung = call basicAuth {username: 'tyeung', password: #(password)}
    * header Authorization = poleary
    * header Content-Type = 'multipart/mixed; boundary="myboundary"'

  Scenario: send mail with only mandatory parameters
    * path 'api','projects',  projectID, 'mail'
    * def requestBody = mailUtils.updateMailSubject(inputDataPath+'/mails/Transmittal')
    * request requestBody
    * method POST
    * print response
    * status 200

  Scenario: list inbox mail
    * header Accept = 'application/vnd.aconex.mail.v2+xml'
    * path 'api','projects',  projectID, 'mail'
    * params {mail_box:'inbox' }
    * method GET
    * print response
    * status 200


  Scenario: send mail with local document Attachment
    * path 'api','projects',  projectID, 'mail'
    * def requestBody = mailUtils.updateMailSubject(inputDataPath+'/mails/SubcontractorsAdvice')
    * request requestBody
    * method POST
    * print response
    * status 200
    * def mailNumber = //NewMailId
    * path 'api','projects', projectID,'mail', mailNumber
    * header Authorization = tyeung
    * header Accept = 'application/vnd.aconex.mail.v2+xml'
    * method GET
    * print response
    * match //FileName == 'ruby_testing.txt'


