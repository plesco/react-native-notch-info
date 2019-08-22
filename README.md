
# react-native-notch-info

## Getting started

`$ npm install react-native-notch-info --save`

### Mostly automatic installation ( no link required for react native 0.60 )

`$ react-native link react-native-notch-info`

#### Manual installation
#### iOS

This is Android only for now.

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
