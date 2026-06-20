import urllib.request
import zipfile
import os
import io

maven_dir = r"c:\Users\KHUSHI\Downloads\java skilling\maven"
zip_url = "https://archive.apache.org/dist/maven/maven-3/3.9.8/binaries/apache-maven-3.9.8-bin.zip"

if not os.path.exists(maven_dir):
    os.makedirs(maven_dir)

zip_path = os.path.join(maven_dir, "maven.zip")

print(f"Downloading Maven from {zip_url}...")
try:
    urllib.request.urlretrieve(zip_url, zip_path)
    print("Download completed. Extracting...")
    
    with zipfile.ZipFile(zip_path, 'r') as zip_ref:
        zip_ref.extractall(maven_dir)
        
    print(f"Extraction completed to {maven_dir}.")
    # Clean up zip file
    os.remove(zip_path)
    print("Temporary zip file removed.")
except Exception as e:
    print(f"Error occurred: {e}")
