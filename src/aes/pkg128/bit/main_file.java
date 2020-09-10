/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aes.pkg128.bit;

/**
 *
 * @author djay1
 */


public class main_file {
    private static final int arr[]={0x54,0x68,0x61,0x74,0x73,0x20,0x6D,0x79,0x20,0x4B,0x75,0x6E,0x67,0x20,0x46,0x75};
    static byte [] getKey(){
        byte [] key = new byte[16];
        for(int i=0;i<16;i++){
            key[i] = (byte)arr[i];
        }
        return key;
    }
}
