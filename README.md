### TCP
- TCP - Transmission Control Protocol
- TCP is a connection-oriented protocol, which means a connection is established and maintained until the application programs at each end have finished exchanging messages.
- TCP is the most commonly used protocol on the Internet. It guarantees the delivery of data with no packets lost and all packets delivered in the order and to the intended recipient.
- However, TCP is slower than UDP because it has more overhead and requires more processing.

### UDP
- UDP - User Datagram Protocol
- UDP is a connectionless protocol, used for datagram-oriented connections such as streaming video, audio, and online gaming.
- UDP is faster than TCP because it has no error-checking and requires less processing.
- Unlike TCP, UDP doesn't guarantee the packets will get to the right destinations. It allows for packets to be dropped and received in a different order than they were sent.
- UDP is like sending a parcel through the mail, you don't know if it will get there. In Java, DatagramSocket acts as a mailman, and DatagramPacket acts as a parcel.