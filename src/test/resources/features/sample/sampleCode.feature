@api
@mails
Feature: Scenarios to verify sendmail with different mail types

  Background: Background
    * url serverUrl
#    * configure ssl = true
    * def basicAuth = read('classpath:sign-in.js')
    * def poleary = call basicAuth {username: 'poleary', password: #(password)}

  Scenario: send mail with only mandatory parameters
    * header Authorization = poleary
    * path 'api','projects'
    * method GET
    * print response
    * status 200
