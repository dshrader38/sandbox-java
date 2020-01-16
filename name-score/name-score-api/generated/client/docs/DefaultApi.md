# DefaultApi

All URIs are relative to *https://localhost:8080/shrader/name-score*

Method | HTTP request | Description
------------- | ------------- | -------------
[**currentWeatherData**](DefaultApi.md#currentWeatherData) | **GET** /add | Add two integers

<a name="currentWeatherData"></a>
# **currentWeatherData**
> _200 currentWeatherData(lhs, rhs)

Add two integers

This function will add two integers and retuen an integer result\&quot;

### Example
```kotlin
// Import classes:
//import io.swagger.client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = DefaultApi()
val lhs : kotlin.Long = 789 // kotlin.Long | Left hand side
val rhs : kotlin.Long = 789 // kotlin.Long | Right hand side
try {
    val result : _200 = apiInstance.currentWeatherData(lhs, rhs)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling DefaultApi#currentWeatherData")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DefaultApi#currentWeatherData")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **lhs** | **kotlin.Long**| Left hand side |
 **rhs** | **kotlin.Long**| Right hand side |

### Return type

[**_200**](_200.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/plain

