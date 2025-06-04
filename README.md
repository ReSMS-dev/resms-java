# ReSMS SDK for Java

[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](https://opensource.org/licenses/MIT)
[![Maven Central](https://img.shields.io/maven-central/v/dev.resms/resms-java-sdk.svg)](https://search.maven.org/artifact/dev.resms/resms-java-sdk)
[![Java Version](https://img.shields.io/badge/Java-11%2B-blue)](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)

A lightweight, easy-to-use Java SDK for [ReSMS](https://resms.dev) - the simple and powerful SMS API for developers.

## 📋 Table of Contents

- [Requirements](#-requirements)
- [Installation](#-installation)
- [Quick Start](#-quick-start)
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

2. **Send your first SMS**

```java
import dev.resms.core.exception.ReSMSException;
import dev.resms.services.sms.model.SendSmsOptions;

public class Main {
  public static void main(String[] args) {
    ReSMS reSms = new ReSMS("re_123");

    SendSmsOptions smsOptions =
        SendSmsOptions.builder()
            .to("+33123456789")
            .message("Welcome to ReSMS!")
            .senderId("ReSMS")
            .build();

    try {
      reSms.sms().send(smsOptions);
    } catch (ReSMSException e) {
      e.printStackTrace();
    }
  }
}

```

## 📚 Documentation

- [API Reference](https://docs.resms.dev/)
- [SDK Documentation](https://docs.resms.dev/quickstart/java)

For complete documentation, visit [resms.dev/docs](https://docs.resms.dev/).
sure to update tests as appropriate.

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
