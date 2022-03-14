#import "RCTDynamicModule.h"

@implementation RCTDynamicModule

// To export a module named RCTCalendarModule
RCT_EXPORT_MODULE(dynamicicon);

RCT_EXPORT_METHOD(changeIcon:(int)id)
{

  dispatch_async(dispatch_get_main_queue(), ^{
    switch(id){
      case 1:
        [[UIApplication sharedApplication] setAlternateIconName:@"icon-1" completionHandler:^(NSError * _Nullable error) {
                //NSLog(error.localizedDescription);
        }];
        break;
      case 2:
        [[UIApplication sharedApplication] setAlternateIconName:@"icon-2" completionHandler:^(NSError * _Nullable error) {
                //NSLog(error.localizedDescription);
        }];
        break;
      case 3:
        [[UIApplication sharedApplication] setAlternateIconName:@"icon-3" completionHandler:^(NSError * _Nullable error) {
                //NSLog(error.localizedDescription);
        }];
        break;
      default:
        [[UIApplication sharedApplication] setAlternateIconName:nil completionHandler:^(NSError * _Nullable error) {
                //NSLog(error.localizedDescription);
        }];
    }
  });

  
}
@end
