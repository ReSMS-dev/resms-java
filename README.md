# ReSMS SDK for Java

[![Maven Central](https://img.shields.io/maven-central/v/dev.resms/resms-java-sdk.svg)](https://search.maven.org/artifact/dev.resms/resms-java-sdk)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Java Version](https://img.shields.io/badge/Java-11%2B-blue)](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)

A lightweight, easy-to-use Java SDK for [ReSMS](https://resms.dev) - the simple and powerful SMS API for developers.

## 📋 Table of Contents

- [Requirements](#-requirements)
- [Installation](#-installation)
- [Quick Start](#-quick-start)
- [Usage Examples](#-usage-examples)
- [Error Handling](#-error-handling)
- [Advanced Configuration](#-advanced-configuration)
- [Documentation](#-documentation)
- [License](#-license)

## 📋 Requirements

- Java 11 or higher
- A ReSMS account with an API key

## 📦 Installation

### Maven

```xml
<dependency>
    <groupId>dev.resms</groupId>
    <artifactId>resms-java-sdk</artifactId>
    <version>1.0.1</version>
</dependency>
```

### Gradle

```groovy
implementation 'dev.resms:resms-java-sdk:1.0.1'
```

### Gradle (Kotlin DSL)

```kotlin
implementation("dev.resms:resms-java-sdk:1.0.1")
```

## 🚀 Quick Start

1. **Get your API key** from the [ReSMS Dashboard](https://resms.dev/dashboard)

2. **Initialize the client**

```java
import dev.resms.ReSMS;

ReSMS client = new ReSMS("your-api-key");
```

3. **Send your first SMS**

```java
import dev.resms.ReSMS;
import dev.resms.exception.ReSMSException;
import dev.resms.model.response.SendSmsResponse;

public class QuickStartExample {
    public static void main(String[] args) {
        ReSMS client = new ReSMS("your-api-key");

        try {
            SendSmsResponse response = client.sendSms("+33123456789", "Hello from ReSMS!");
            System.out.println("Message sent! ID: " + response.getData().getMessageId());
        } catch (ReSMSException e) {
            System.err.println("Error sending SMS: " + e.getMessage());
        }
    }
}
```

## 📱 Usage Examples

### Basic SMS Sending

```java
import dev.resms.ReSMS;
import dev.resms.model.response.SendSmsResponse;

public class BasicExample {
    public static void main(String[] args) {
        // Initialize the client
        ReSMS client = new ReSMS("your-api-key");

        try {
            // Send an SMS
            SendSmsResponse response = client.sendSms("+33123456789", "Welcome to ReSMS!");

            // Get the message ID and status
            String messageId = response.getData().getMessageId();
            String status = response.getStatus();

            System.out.println("Message sent successfully!");
            System.out.println("Message ID: " + messageId);
            System.out.println("Status: " + status);
        } catch (ReSMSException e) {
            System.err.println("Failed to send SMS: " + e.getMessage());
        }
    }
}
```

### Using Custom Configuration

```java
import dev.resms.ReSMS;
import dev.resms.config.ReSMSConfig;

public class ConfigExample {
    public static void main(String[] args) {
        // Create a custom configuration
        ReSMSConfig config = new ReSMSConfig("your-api-key");

        // Initialize the client with the custom configuration
        ReSMS client = new ReSMS(config);

        // Now you can use the client as usual
        // ...
    }
}
```

## ⚠️ Error Handling

The SDK uses a comprehensive exception hierarchy to help you handle errors effectively:

- `ReSMSException`: Base exception class for all ReSMS-related errors

### Specific Exceptions

All these exceptions extend `ReSMSException`:

- `InvalidApiKeyException`: Thrown when the API key is invalid
- `CountryDetectionFailedException`: Thrown when the country of the phone number cannot be detected
- `PhoneNumberParsingFailedException`: Thrown when the phone number cannot be parsed
- `InsufficientSmsQuotaException`: Thrown when you don't have enough SMS quota
- `MessageStatusUpdateFailedException`: Thrown when the message status cannot be updated

### Example: Handling Specific Exceptions

```java
import dev.resms.ReSMS;
import dev.resms.exception.ReSMSException;
import dev.resms.exception.sms.InsufficientSmsQuotaException;
import dev.resms.exception.user.InvalidApiKeyException;

public class ErrorHandlingExample {
    public static void main(String[] args) {
        ReSMS client = new ReSMS("your-api-key");

        try {
            client.sendSms("+33123456789", "Test message");
            System.out.println("Message sent successfully!");
        } catch (InvalidApiKeyException e) {
            System.err.println("Authentication error: " + e.getMessage());
            System.err.println("Please check your API key");
        } catch (InsufficientSmsQuotaException e) {
            System.err.println("Quota exceeded: " + e.getMessage());
            System.err.println("Please upgrade your plan");
        } catch (ReSMSException e) {
            System.err.println("ReSMS error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }
}
```

## ⚙️ Advanced Configuration

The `ReSMSConfig` class allows you to customize the SDK's behavior:

```java
import dev.resms.ReSMS;
import dev.resms.config.ReSMSConfig;

// Create a configuration with your API key
ReSMSConfig config = new ReSMSConfig("your-api-key");

        // Initialize the client with the configuration
        ReSMS client = new ReSMS(config);
```

## 📚 Documentation

- [API Reference](https://docs.resms.dev/)
- [SDK Documentation](https://docs.resms.dev/quickstart/java)

For complete documentation, visit [resms.dev/docs](https://docs.resms.dev/).
sure to update tests as appropriate.

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
