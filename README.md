# ReSMS SDK for Java
Java SDK for ReSMS, a simple and powerful SMS API.

## Installation

```maven
<dependency>
    <groupId>dev.resms</groupId>
    <artifactId>resms-java</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Setup
You need to get an API key on [ReSMS Dashboard](https://resms.dev/dashboard).
Then import the package and create a new instance of the `ReSMS` class with your API key.

```java
// Initialize with your API key
ReSMS sms = new ReSMS("your_api_key_here");

// Optionally specify a custom timeout (in seconds)
ReSMS smsWithCustomTimeout = new ReSMS("your_api_key_here", 30);
```

## Usage
Send you can send your SMS:
```java
public class SmsExample {
    public static void main(String[] args) {
        // Create ReSMS client instance
        ReSMS sms = new ReSMS("re_12345");
        
        try {
            // Send SMS message
            ReSMS.SendResult result = sms.send("+33123456789", "Your sign-in code is 123456");
            System.out.println("SMS sent successfully: " + result);
            
            // Access the message ID and status
            String messageId = result.getId();
            String status = result.getStatus();
            System.out.println("Message ID: " + messageId);
            System.out.println("Status: " + status);
        } catch (ReSMS.ReSMSException e) {
            System.out.println("API Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Failed to send SMS: " + e.getMessage());
        }
    }
}
```

## Error Handling
The SDK throws different types of exceptions:

```ReSMSException```: Thrown when the API returns a non-2xx response.

```IOException```: Thrown when there's an error with the HTTP request.

```InterruptedException```: Thrown if the HTTP request is interrupted.

## Documentation
The full documentation is available at [resms.dev/docs](https://resms.dev/docs).

## License
This project is licensed under the MIT License.

## Note
This is a simple SDK for ReSMS. More features and improvements will be added in the future. If you have any suggestions or issues, please open an issue on GitHub.
