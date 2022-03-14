/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow strict-local
 */

import React from 'react';
import {
  SafeAreaView,
  ScrollView,
  StatusBar,
  StyleSheet,
  Text,
  useColorScheme,
  View,
  Image,
  NativeModules,
  TouchableOpacity,
  Platform
} from 'react-native';

import {
  Colors,
  DebugInstructions,
  Header,
  LearnMoreLinks,
  ReloadInstructions,
} from 'react-native/Libraries/NewAppScreen';
import AppIcon from 'react-native-dynamic-app-icon';

const ICONS = [1,2,3]
const App = () => {
  const isDarkMode = useColorScheme() === 'dark';
  const getSource = (id) => {
    switch (id){
      case 1:
        return require('./assets/1.png')
      case 2:
        return require('./assets/2.png')
      case 3:
        return require('./assets/3.jpeg')
      default:
        return require('./assets/1.png')
    }
      
  }
  const backgroundStyle = {
    backgroundColor: '#fff',
    height: '100%'
  };

  const changeIcon = (id) => {
    console.log("id: ", id)
    if(Platform.OS === 'android'){
      NativeModules.dynamicicon.changeIcon(id)
      return
    }
    AppIcon.supportsDynamicAppIcon()
    .then(s => {
      console.log('supports icon change: ', s)

    })

    if(id == 1){
      AppIcon.setAppIcon('alternate');

    } else if (id == 2){
      AppIcon.setAppIcon('alternate2');

    } else if (id == 3){
      AppIcon.setAppIcon('alternate3');
    }
    else {
      AppIcon.setAppIcon(null);

    }
  }
  return (
    <SafeAreaView style={backgroundStyle}>
      <StatusBar barStyle={'dark-content'} />
      
        <View
          style={{
            //backgroundColor: isDarkMode ? Colors.black : Colors.white,
            marginVertical: 24
          }}>
            {ICONS.map(i => {
              return (
                <TouchableOpacity onPress = {() => changeIcon(i)} style = {styles.row}>
                  <Image source = {getSource(i)} style = {styles.img}/>
                  <Text>
                    {'change to icon #' + i}
                  </Text>
                </TouchableOpacity >
              )
            })}
        </View>
    </SafeAreaView>
  );
};

const styles = StyleSheet.create({
  sectionContainer: {
    marginTop: 32,
    paddingHorizontal: 24,
  },
  sectionTitle: {
    fontSize: 24,
    fontWeight: '600',
  },
  img:{
    width: 60,
    height: 60
  },
  row: {
    width: '60%',
    flexDirection: 'row',
    alignItems: 'center',
    alignSelf: 'center',
    justifyContent: 'space-between',
    marginVertical: 24
  },
  sectionDescription: {
    marginTop: 8,
    fontSize: 18,
    fontWeight: '400',
  },
  highlight: {
    fontWeight: '700',
  },
});

export default App;
