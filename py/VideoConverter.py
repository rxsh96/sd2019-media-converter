from converter import Converter
import sys

def convert_video(video_name, new_format):
	'''Function that will convert a specific video-format to another 
		Parameters
        ----------
        video_name : str
            The video's path that the user wants to convert.
        new_format : str
        	The video's new format.
        Returns
	    -------
	    File
	        A video file with the new format. 
	'''
	conv = Converter()
    convert = conv.convert(video_name, video_name+'.'+new_format) {
    'format': new_format,
    'audio': {
        'codec': 'aac',
        'samplerate': 11025,
        'channels': 2
    },
    'video': {
        'codec': 'hevc',
        'width': 720,
        'height': 400,
        'fps': 25
    }})
    
    for timecode in convert:
        print(f'\rConverting ({timecode:.2f}) ...')

    return convert


def main(argv):
    video = convert_video(argv[0], argv[1])


if __name__ == '__main__':
    main(sys.argv[1:])