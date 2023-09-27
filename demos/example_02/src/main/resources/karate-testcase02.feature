Feature: browser automation 1

  Background:
#    * configure driver = { type: 'chrome', showDriverLog: false, headless: true, start: true, addOptions: ['--disable-gpu','--headless=new','--remote-debugging-port=9222','--no-sandbox','--remote-allow-origins=*' ] }
#    * configure driver = { type: 'chrome', showDriverLog: false, headless: true, start: true, addOptions: ['--headless=new','--remote-debugging-port=9222','--no-sandbox','--remote-allow-origins=*' ] }
    * configure driver = { type: 'chrome', showDriverLog: false, headless: false, start: true}
#

#   * configure driverTarget = { docker: 'justinribeiro/chrome-headless', showDriverLog: true }
#    * configure driver = { type: 'chromedriver', headless: true, start: true, showDriverLog: true }
  # * configure driverTarget = { docker: 'ptrthomas/karate-chrome', showDriverLog: true }
  # * configure driver = { type: 'chromedriver', showDriverLog: true }
  # * configure driver = { type: 'geckodriver', showDriverLog: true }
  # * configure driver = { type: 'safaridriver', showDriverLog: true }
  # * configure driver = { type: 'iedriver', showDriverLog: true, httpConfig: { readTimeout: 120000 } }

  Scenario: try to login to github
  and then do a google search

    Given driver 'http://localhost:5173/'
    Then waitForUrl('http://localhost:5173/')
    Then waitFor('#mapContainer > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > canvas:nth-child(1)')
    Then highlight('#mapContainer > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > canvas:nth-child(1)')
    Then highlight('#mapContainer')
    Then waitFor('#app.mx-auto.container div.text-gray-600')
    Then screenshot()
    Then highlight('#app.mx-auto.container div.text-gray-600')
    Then screenshot('#app')
    Then match html('#app.mx-auto.container div.text-gray-600') contains 'Ayodhya Ram Mandir'

