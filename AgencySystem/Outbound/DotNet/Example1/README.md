# Altinn Batch Receiver Sample

There are two solutions in this sample:
* AltinnBatchReceiverService
* AltinnSimulator

## AltinnBatchReceiverService
This is the server which receives messages from Altinn. To test the server:

* Make sure you have .NET 4.5.2 installed
* Open the solution in Visual Studio 2015 or later.
* Run

Two folders will be created:
* Log
  Contains log.txt
* Inbox
  Contains the received messages
  
The Service will also log to Windows Application Log.

There is more documentation within the source files.

## AltinnSimulator
This console application simulates Altinn by fetching testdata and sending it to the AltinnBatchReceiverService.
It fetches data from the Testdata folder.
In order to run:

* Make sure you have .NET 4.5.2 installed
* Open the solution in Visual Studio 2015 or later.
* Run the AltinnBatchReceiverService
* Select properties > Debug, edit the Command Line:
  folder ..\..\Tesdata
* Run the console application

