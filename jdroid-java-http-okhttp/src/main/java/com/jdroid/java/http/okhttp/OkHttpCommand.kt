package com.jdroid.java.http.okhttp

import com.jdroid.java.exception.UnexpectedException

import com.jdroid.java.http.exception.ConnectionException

import java.io.IOException
import java.io.InterruptedIOException
import java.net.ConnectException
import java.net.NoRouteToHostException
import java.net.ProtocolException
import java.net.SocketException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

import javax.net.ssl.SSLException
import javax.net.ssl.SSLHandshakeException

abstract class OkHttpCommand<P, R> {

    fun execute(param: P): R? {
        try {
            return doExecute(param)
        } catch (e: SocketTimeoutException) {
            throw ConnectionException(e, true)
        } catch (e: ConnectException) {
            throw ConnectionException(e, false)
        } catch (e: UnknownHostException) {
            throw ConnectionException(e, false)
        } catch (e: InterruptedIOException) {
            throw ConnectionException(e, true)
        } catch (e: NoRouteToHostException) {
            throw ConnectionException(e, false)
        } catch (e: SocketException) {
            var message: String? = e.message
            if (message != null) {
                if (message == "Software caused connection abort") {
                    throw ConnectionException(e, false)
                } else if (message == "sendto failed: ENOTSOCK (Socket operation on non-socket)") {
                    throw ConnectionException(e, true)
                } else if (message == "Connection timed out") {
                    throw ConnectionException(e, false)
                } else if (message == "Connection reset") {
                    throw ConnectionException(e, true)
                } else if (message == "Network is unreachable") {
                    throw ConnectionException(e, true)
                } else if (message == "Connection refused") {
                    throw ConnectionException(e, true)
                } else {
                    throw ConnectionException(e, false)
                }
            }

            val cause = e.cause
            if (cause != null) {
                message = cause.message
                if (message != null) {
                    if (message.contains("isConnected failed: EHOSTUNREACH (No route to host)")) {
                        throw ConnectionException(e, false)
                    } else if (message.contains("recvfrom failed: ETIMEDOUT (Connection timed out)")) {
                        throw ConnectionException(e, true)
                    } else if (message.contains("recvfrom failed: ECONNRESET (Connection reset by peer)")) {
                        throw ConnectionException(e, false)
                    } else if (message.contains("recvfrom failed: ECONNREFUSED (Connection refused)")) {
                        throw ConnectionException(e, false)
                    } else if (message.contains("sendto failed: ETIMEDOUT (Connection timed out)")) {
                        throw ConnectionException(e, true)
                    } else if (message == "Connection reset") {
                        throw ConnectionException(e, true)
                    }
                }
            }
            throw UnexpectedException(e)
        } catch (e: SSLHandshakeException) {
            throw ConnectionException(e, false)
        } catch (e: SSLException) {
            val message = e.message
            if (message != null) {
                if (message.startsWith("Read error:") && message.endsWith("I/O error during system call, Connection reset by peer")) {
                    throw ConnectionException(e, true)
                } else if (message.startsWith("Read error:")) {
                    throw ConnectionException(e, true)
                } else if (message.startsWith("SSL handshake aborted:") && message.endsWith("I/O error during system call, Connection reset by peer")) {
                    throw ConnectionException(e, false)
                } else if (message == "Connection closed by peer") {
                    throw ConnectionException(e, false)
                }
            }
            throw UnexpectedException(e)
        } catch (e: ProtocolException) {
            val message = e.message
            if (message != null && message == "Too many follow-up requests: 21") {
                throw ConnectionException(e, false)
            }
            throw UnexpectedException(e)
        } catch (e: IOException) {
            val message = e.message
            if (message != null && message.contains("unexpected end of stream on")) {
                throw ConnectionException(e, true)
            }
            throw UnexpectedException(e)
        }
    }

    @Throws(IOException::class)
    protected abstract fun doExecute(param: P): R?
}
