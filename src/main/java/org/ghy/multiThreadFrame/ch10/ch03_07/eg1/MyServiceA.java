package org.ghy.multiThreadFrame.ch10.ch03_07.eg1;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class MyServiceA {
    public TransferQueue queue = new LinkedTransferQueue();
}
