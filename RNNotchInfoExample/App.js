/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow
 */

import React, {Fragment} from 'react';
import {
  SafeAreaView,
  StyleSheet,
  ScrollView,
  View,
  Text,
  StatusBar,
  Platform
} from 'react-native';

import RNNotchInfo from 'react-native-notch-info';

class App extends React.Component{

  state = {
    hasNotch : false,
    notchHeight: 0,
  }

  componentDidMount = () => {
      RNNotchInfo.hasNotch(( hasNotch ) => this.setState({ hasNotch : hasNotch }));
      RNNotchInfo.notchHeight((notchHeight) => this.setState({ notchHeight: notchHeight}));
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

const styles = StyleSheet.create({

});

export default App;
