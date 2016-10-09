# ActivityRecognition
Simple test app that monitors sensor data and sends it to a remote server according to a set schedule.

## Bulletpoint Summary
###Basic Ideas:
- Chosen sensors: light sensor, accelometer, magnetometer,
- Data is collected according to a chosen schedule (eg. 5min, 15min, 30min, 1hr)
- Data is stored localy in a database
- Once a day data is sent to the server
- Stopping registered schedule
- Possibility to start service automatically after reboot
- Data sent to the server in JSON format

###Additional Ideas (aka "if there's enough time"):
- Implement battery efficient solution
- Enable force manual synchronization to the server
- Main Screen shows live data from the sensors
- Main Screen visualises the data from sensors
- View historic data


##Database structure

Simple database scheme for storing acquired sensor readings. DB will be implemented using SQLite

![Database Scheme](https://i.imgur.com/enrHbEo.png)

##JSON structure

describe it here

##Dataflow

Put some pictures in here

##Data Recogniton Research
- [one](http://cs229.stanford.edu/proj2015/107_report.pdf)
- [two](https://www.researchgate.net/publication/294578183_Human_Activity_Recognition_Using_Sensor_Data_of_Smartphones_and_Smartwatches)
- [three](http://ebooks.iospress.nl/publication/40069)


