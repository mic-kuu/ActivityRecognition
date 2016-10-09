# ActivityRecognition
Simple app that monitors sensor data and sends it to a remote server according to a choosen schedule. 

## Bulletpoint Summary
###General Ideas:
- Chosen sensors: light sensor, accelometer, magnetometer, gyroscope
- Data is collected according to a chosen schedule (eg. 5min, 15min, 30min, 1hr)
- Data is stored localy in a database
- Once a day data is sent to the server
- Stopping registered schedule
- Possibility to start service automatically after reboot
- Data sent to the server in JSON format

###Possible improvements (aka "if there's enough time"):
- Implement battery efficient solution
- Enable force manual synchronization to the server
- Main Screen shows live data from the sensors
- Main Screen visualises the data from sensors
- View historic data


##Database structure

Simple database scheme for storing acquired sensor readings. DB will be implemented using SQLite

![Database Scheme](https://i.imgur.com/enrHbEo.png)

##JSON structure
That is the JSON format that will be used to transfer sensor data to the server. The device will be identyfied by its IMEI number. All the data that the sensor has gathered will be stored in an array. Each item in the array contains: timestamp, values (in x,y,z directions if applicable) and accuracy of the sensor.

```json
{
  "sensorReadings":{
    "deviceID": "35145120840121",
    "lightSensor": [
      { 
        "timestamp": "2016-10-30 T 10:45 UTC",
        "value": "1234",
        "accuracy": 2
      },
      { 
        "timestamp": "2016-10-30 T 10:47 UTC",
        "value": "1234",
        "accuracy": 2
      }  
    ],
    "accelometerSensor": [
      {
        "timestamp": "2016-10-30 T 10:45 UTC",
        "valueX": "1234",
        "valueY": "1234",
        "valueZ": "234",
        "accuracy": 2
      }
    ],
    "gyroscopeSensor": [
      {
        "timestamp": "2016-10-30 T 10:45 UTC",
        "valueX": "1234",
        "valueY": "1234",
        "valueZ": "234",
        "accuracy": 2
      }
    ],
    "magneticSensor": [
      {
        "timestamp": "2016-10-30 T 10:45 UTC",
        "valueX": "1234",
        "valueY": "1234",
        "valueZ": "234",
        "accuracy": 2
      }
    ]
  }
}
```

##Dataflow

Put some pictures in here

##Data Recogniton Research
- [one](http://cs229.stanford.edu/proj2015/107_report.pdf)
- [two](https://www.researchgate.net/publication/294578183_Human_Activity_Recognition_Using_Sensor_Data_of_Smartphones_and_Smartwatches)
- [three](http://ebooks.iospress.nl/publication/40069)


