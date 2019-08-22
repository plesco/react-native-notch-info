//
//  ScreenDimensions.m
//  RNNotchInfo
//
//  Created by Gligan Natalia on 21/08/2019.
//  Copyright © 2019 Facebook. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "ScreenDimensions.h"
#import <UIKit/UIKit.h>

@implementation ScreenDimensions

RCT_EXPORT_MODULE();

//exports a method getDeviceName to javascript
RCT_EXPORT_METHOD(getDeviceName:(RCTResponseSenderBlock)callback){
    @try{
        NSString *deviceName = [[UIDevice currentDevice] name];
        callback(@[[NSNull null], deviceName]);
    }
    @catch(NSException *exception){
        callback(@[exception.reason, [NSNull null]]);
    }
}


RCT_EXPORT_METHOD(hasNotch:(RCTResponseSenderBlock) callback){
    @try{
        dispatch_async(dispatch_get_main_queue(), ^() {
            UIWindow *mainWindow = [[[UIApplication sharedApplication] delegate] window];
            bool   hasNotch = false;
            if (@available(iOS 11.0, *)) {
                if (mainWindow.safeAreaInsets.bottom > 0) {
                    hasNotch = true;
                }
            }
            callback(@[[NSNumber numberWithBool:hasNotch]]);
        });
    }
    @catch(NSException *exception){
        callback(@[exception.reason]);
    }
}

RCT_EXPORT_METHOD(notchHeight:(RCTResponseSenderBlock) callback){
    @try{
        dispatch_async(dispatch_get_main_queue(), ^() {
            UIWindow *mainWindow = [[[UIApplication sharedApplication] delegate] window];
            int notchHeight = 0;
            bool   hasNotch = false;
            if (@available(iOS 11.0, *)) {
                notchHeight = mainWindow.safeAreaInsets.bottom;
                if (mainWindow.safeAreaInsets.bottom > 0) {
                    hasNotch = true;
                }
            }
            callback(@[[NSString stringWithFormat:@"%i", notchHeight]]);
        });
    }
    @catch(NSException *exception){
        callback(@[exception.reason]);
    }
}

@end
