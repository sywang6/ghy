package org.ghy.multiThreadFrame.ch10.ch03_07.eg4;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class MyServiceB {
    public TransferQueue queue = new LinkedTransferQueue();
}
