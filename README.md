
# react-native-notch-info

## Getting started

`$ npm install react-native-notch-info --save`

### Mostly automatic installation ( no link required for react native 0.60 )

`$ react-native link react-native-notch-info`

#### Manual installation
#### iOS (via CocoaPods)
Add the following lines to your build targets in your Podfile

```
pod 'React', :path => '../node_modules/react-native'

# Explicitly include Yoga if you are using RN >= 0.42.0
pod 'yoga', :path => '../node_modules/react-native/ReactCommon/yoga'

pod 'RNNotchInfo', :path => '../node_modules/react-native-notch-info'

```

Then run `pod install`

#### iOS (via CocoaPods)

In XCode, in the project navigator:

1. Right click `Libraries`
2. Add Files to `[your project's name]`
3. Go to `node_modules/react-native-notch-info/ios`
4. Add the file `RNNotchInfo.xcodeproj`
5. In XCode, in the project navigator, select your project.

Add the `libRNNotchInfo.a` from the notchinfo project to your project's Build Phases ➜ Link Binary With Libraries
Click `.xcodeproj` file you added before in the project navigator and go the Build Settings tab. Make sure All is toggled on (instead of Basic).
Look for Header Search Paths and make sure it contains both $(SRCROOT)/../react-native/React and $(SRCROOT)/../../React
Mark both as recursive (should be OK by default).

Run your project (Cmd+R)


#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNNotchInfoPackage;` to the imports at the top of the file
  - Add `new RNNotchInfoPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-notch-info'
  	project(':react-native-notch-info').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-notch-info/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-notch-info')
  	```


## Usage
```javascript
class App extends React.Component{

  state = {
    hasNotch : false,
    notchHeight: 0,
  }

  componentDidMount = () => {
    if (Platform.OS === "android") {
      RNNotchInfo.hasNotch(( hasNotch ) => this.setState({ hasNotch : hasNotch }));
      RNNotchInfo.notchHeight((notchHeight) => this.setState({ notchHeight: notchHeight}));
    }
  }

  render(){
    return (
      <Fragment>
        <StatusBar barStyle="dark-content" />
        <SafeAreaView style={{flex:1, flexDirection: "column", justifyContent: "center", alignItems: "center"}}>

          <Text>{this.state.hasNotch ? "This phone has notch" : "This phone does not have notch"}</Text>
          <Text>Notch height is {this.state.notchHeight} pixels</Text>

        </SafeAreaView>
      </Fragment>
    );
  }
}

```
